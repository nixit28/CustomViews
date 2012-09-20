package com.nix.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageCheckedTextView extends LinearLayout{

	private View customView;
	private int txtColor;
	private int imgSrc;
	private String txtContent;
	private CheckedTextView chkTxtView;
	private ImageView imgView;
	private int viewSelector;

	public ImageCheckedTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context, attrs);
	}

	public ImageCheckedTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context, attrs);
	}

	public ImageCheckedTextView(Context context) {
		super(context);
		initView(context, null);
	}

	private void initView(Context context, AttributeSet attrs){
		LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		customView = inflator.inflate(R.layout.my_view, null);
		this.addView(customView);
		parseAttributes(context, attrs);
	}

	private void parseAttributes(Context context, AttributeSet attrs) {
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ImageCheckedText);
		try{
			txtColor = ta.getColor(R.styleable.ImageCheckedText_txtColor, Color.BLACK);
			txtContent = ta.getString(R.styleable.ImageCheckedText_txtContent);
			imgSrc = ta.getResourceId(R.styleable.ImageCheckedText_imgLogoSrc, R.drawable.ic_launcher);
			viewSelector = ta.getResourceId(R.styleable.ImageCheckedText_viewSelector, R.drawable.view_selector);
		}finally{
			ta.recycle();
		}
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		initViewObjects();
		
	}

	private void initViewObjects() {
		chkTxtView = (CheckedTextView)findViewById(android.R.id.text1);
		imgView = (ImageView)findViewById(R.id.imageView);
		chkTxtView.setText(txtContent);
		chkTxtView.setTextColor(txtColor);
		imgView.setImageResource(imgSrc);
		this.setBackgroundResource(viewSelector);
	}

	public CheckedTextView getWrapedChkTxtView() {
		return chkTxtView;
	}

	public ImageView getWrapedImgView() {
		return imgView;
	}
	@Override
	public void setOnClickListener(OnClickListener l) {
		super.setOnClickListener(l);
	}
}
