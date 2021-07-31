package com.example.bongolingo;

public class Word {
    String mBengaliTranslation;
    String mDefaultTranslation;
    int mImageResourceId = NO_IMAGE_PROVIDED;
    int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String bengaliTranslation, String defaultTranslation, int imageResourceId, int audioResourceId){
        mBengaliTranslation = bengaliTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public Word(String bengaliTranslation, String defaultTranslation, int audioResourceId){
        mBengaliTranslation = bengaliTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String bengaliTranslation, String defaultTranslation){
        mBengaliTranslation = bengaliTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public String getBengaliTranslation(){
        return mBengaliTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}
