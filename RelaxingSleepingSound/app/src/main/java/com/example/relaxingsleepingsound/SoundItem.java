package com.example.relaxingsleepingsound;

public class SoundItem {
    private String nameEn, nameEl;
    private int resId;

    public SoundItem(String nameEn, String nameEl, int resId) {
        this.nameEn = nameEn;
        this.nameEl = nameEl;
        this.resId = resId;
    }

    public String getName(boolean isGreek) { return isGreek ? nameEl : nameEn; }
    public int getResId() { return resId; }
}