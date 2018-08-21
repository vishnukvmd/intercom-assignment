package com.intercom.interview.test.util;

import com.intercom.interview.test.models.Location;

import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class DistanceComputer {
    private static final int RADIUS_OF_EARTH_IN_KILOMETERS = 6371;

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Great-circle_distance#Formulas">Great-circle distance
    </a>
     */
    public static double computeDistance(Location firstLocation, Location secondLocation) {
        double phi1 = toRadians(firstLocation.latitude);
        double lambda1 = toRadians(firstLocation.longitude);
        double phi2 = toRadians(secondLocation.latitude);
        double lambda2 = toRadians(secondLocation.longitude);

        double deltaLambda = Math.abs(lambda1 - lambda2);

        double deltaSigma = acos((sin(phi1) * sin(phi2)) +
                (cos(phi1) * cos(phi2) * cos(deltaLambda)));

        return deltaSigma * RADIUS_OF_EARTH_IN_KILOMETERS;
    }
}
