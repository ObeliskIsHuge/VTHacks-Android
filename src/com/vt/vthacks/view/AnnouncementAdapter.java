package com.vt.vthacks.view;

import android.view.LayoutInflater;
import java.util.ArrayList;
import android.content.Context;
import com.vt.vthacks.model.IAnnouncement;
import android.widget.ArrayAdapter;

// -------------------------------------------------------------------------
/**
 *
 *  This is the class that handles the Adapter that will be used in the
 *  Announcement Activity
 *
 *  @author Brandon Potts
 *  @version Mar 22, 2014
 */
public class AnnouncementAdapter extends ArrayAdapter<IAnnouncement>
{

    private Context mContext;
    private LayoutInflater mInflater;



    // ----------------------------------------------------------
    /**
     * Create a new AnnouncementAdapter object.
     * @param context
     * @param resource
     * @param objects
     */
    public AnnouncementAdapter(
        Context context,
        int resource,
        ArrayList<IAnnouncement> objects)
    {
        super(context, resource, objects);
        this.mContext = context;
        // TODO Auto-generated constructor stub
    }

}
