package com.citoneitor.Adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.citoneitor.Fragment.FragmentCitasPasadas;
import com.citoneitor.Fragment.FragmentProximasCitas;

/**
 * Created by ruben on 23/03/16.
 */
public class AdaptadorCitasTabs extends FragmentStatePagerAdapter {

    public AdaptadorCitasTabs(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0 :

                return new FragmentProximasCitas();
            case 1 :

                return new FragmentCitasPasadas();
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
