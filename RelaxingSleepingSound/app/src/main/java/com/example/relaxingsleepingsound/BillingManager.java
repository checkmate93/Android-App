package com.example.relaxingsleepingsound;

import android.content.Context;
import android.content.SharedPreferences;

public class BillingManager {
    private SharedPreferences prefs;

    public BillingManager(Context context) {
        prefs = context.getSharedPreferences("SleepyPrefs", Context.MODE_PRIVATE);
    }

    // Αποθήκευση αγοράς (Remove Ads)
    public void setAdsRemoved(boolean removed) {
        prefs.edit().putBoolean("ads_removed", removed).apply();
    }

    public boolean areAdsRemoved() {
        return prefs.getBoolean("ads_removed", false);
    }

    // Διαχείριση κωδικού ασφαλείας (Memory storage)
    public void saveSecurityCode(String code) {
        prefs.edit().putString("security_code", code).apply();
    }

    public String getSecurityCode() {
        return prefs.getString("security_code", "0000"); // Default code
    }
}