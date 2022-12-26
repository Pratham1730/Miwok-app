package com.example.android.miwok;

public class word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImagesResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private  int mAudioResource;

    public word(String DefaultTranslation , String MiwokTranslation, int ImageResourceId, int AudioResource)
    {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImagesResourceId = ImageResourceId;
        mAudioResource = AudioResource;
    }

    public word(String DefaultTranslation , String MiwokTranslation,int  AudioResource)
    {
        mDefaultTranslation = DefaultTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResource = AudioResource;
    }


    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getImagesResourceId()
    {
        return  mImagesResourceId;
    }

    public boolean hasImage()
    {
        return mImagesResourceId != NO_IMAGE_PROVIDED;
    }

    public int GetAudioResource()
    {
        return  mAudioResource;
    }
}

