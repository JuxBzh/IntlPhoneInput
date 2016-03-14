package net.rimoto.intlphoneinput;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountrySpinnerAdapter extends ArrayAdapter<Country> {
    private LayoutInflater mLayoutInflater;

    private int mCountryNameColor;
    private int mDialCodeColor;

    /**
     * Constructor
     *
     * @param context Context
     */
    public CountrySpinnerAdapter(Context context, int countryNameColor, int dialCodeColor) {
        super(context, 0);
        mLayoutInflater = LayoutInflater.from(context);
        mCountryNameColor = countryNameColor;
        mDialCodeColor = dialCodeColor;
    }

    /**
     * Drop down item view
     *
     * @param position    position of item
     * @param convertView View of item
     * @param parent      parent view of item's view
     * @return covertView
     */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        final DropDownViewHolder viewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.dropdown_item_country, parent, false);
            viewHolder = new DropDownViewHolder();
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.intl_phone_edit__country__item_image);
            viewHolder.mNameView = (TextView) convertView.findViewById(R.id.intl_phone_edit__country__item_name);
            viewHolder.mNameView.setTextColor(mCountryNameColor);
            viewHolder.mDialCode = (TextView) convertView.findViewById(R.id.intl_phone_edit__country__item_dialcode);
            viewHolder.mDialCode.setTextColor(mDialCodeColor);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (DropDownViewHolder) convertView.getTag();
        }

        Country country = getItem(position);
        viewHolder.mImageView.setImageResource(getFlagResource(country));
        viewHolder.mNameView.setText(country.getName());
        viewHolder.mDialCode.setText(String.format("+%s", country.getDialCode()));
        return convertView;
    }

    /**
     * Drop down selected view
     *
     * @param position    position of selected item
     * @param convertView View of selected item
     * @param parent      parent of selected view
     * @return convertView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Country country = getItem(position);

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.spinner_item_country, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.country_flag);
            convertView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mImageView.setImageResource(getFlagResource(country));

        return convertView;
    }

    /**
     * Fetch flag resource by Country
     *
     * @param country Country
     * @return int of resource | 0 value if not exists
     */
    private int getFlagResource(Country country) {
        return getContext().getResources().getIdentifier("country_" + country.getIso().toLowerCase(), "drawable", getContext().getPackageName());
    }


    /**
     * View holder for caching. Used in {@link #getDropDownView(int, View, ViewGroup)}
     */
    private static class DropDownViewHolder {
        public ImageView mImageView;
        public TextView mNameView;
        public TextView mDialCode;
    }

    /**
     * View holder for caching. Used in {@link #getView(int, View, ViewGroup)}
     */
    private static class ViewHolder {
        ImageView mImageView;
    }
}
