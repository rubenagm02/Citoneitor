package com.citoneitor.Adaptadores;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.citoneitor.Fragment.FragmentCitasPasadas;
import com.citoneitor.Fragment.FragmentProximasCitas;

/**
 * Created by ruben on 23/03/16.
 */
public class AdaptadorCitasTabs extends FragmentStatePagerAdapter {

    private Activity activity;
    public AdaptadorCitasTabs(FragmentManager fm, Activity activity) {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0 :
                FragmentProximasCitas fragmentProximasCitas = new FragmentProximasCitas();
                fragmentProximasCitas.setActivity(activity);
                return fragmentProximasCitas;
            case 1 :
                FragmentCitasPasadas fragmentCitasPasadas = new FragmentCitasPasadas();
                fragmentCitasPasadas.setActivity(activity);
                return fragmentCitasPasadas;
            default:

                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Próximas citas";
            case 1:
                return "Citas pasadas";
            default:
                return "Tab";
        }
    }
}
