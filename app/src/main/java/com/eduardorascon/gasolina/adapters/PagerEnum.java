public enum PagerEnum {
	RED(R.string.red, R.layout.view_red),
	BLUE(R.string.blue, R.layout.view_blue)

	private int mTitleResId, mLayoutResId;

	PagerEnum(int titleResId, int layoutResId) {
		mTitleResId = titleResId;
		mLayoutResId = layoutResId;
	}

	public int getTitleResId(){
		return mTitleResId;
	}

	public int getLayoutResId(){
		return mLayoutResId;
	}
}