package com.openxc.measurements;

import com.openxc.units.KilometersPerHour;
import com.openxc.util.Range;

/**
 * The VehicleSpeed is the current forward speed of the vehicle.
 */
public class VehicleSpeed extends BaseMeasurement<KilometersPerHour> {
    // TODO this should change based on the vehicle platform - needs to be read
    // from the CAN translator (which has this info stored statically)
    private final static Range<KilometersPerHour> RANGE =
        new Range<KilometersPerHour>(new KilometersPerHour(0.0),
                new KilometersPerHour(655.0));
    public final static String ID = "vehicle_speed";

    public VehicleSpeed(KilometersPerHour value) {
        super(value, RANGE);
    }

    public VehicleSpeed(Double value) {
        this(new KilometersPerHour(value));
    }
}
