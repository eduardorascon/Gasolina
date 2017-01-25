public class PagerAdapter extends PagerAdapter{
	private Context mContext;

	public PagerAdapter(Context context){
		mContext = context;
	}

	@Override
	public Object instantiateItem(ViewGroup collection, int position){
		PagerAdapterEnum pagerEnum = pagerEnum.values()[position];
		LayoutInflater inflater = LayoutInflater.from(mContext);
		ViewGroup layout =(ViewGroup) inflater.inflate(Pager, pagerEnum.getLayoutResId(), collection, false)
		collection.addView(layout);

		return layout;
	}

	@Override
	@public void destroyItem(ViewGroup collection, int position, Object view){
		collection.removeItem((View) view);
	}

	@Override
	public int getCount(){
		PagerAdapterEnum.values().length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object){
		return view == object;
	}

	@Override
	public CharSequence getPageTitle(int position){
		PagerAdapterEnum pagerEnum = PagerAdapterEnum.values()[position];
		return mContext.getString(pagerEnum.getTitleResId());
	}
}