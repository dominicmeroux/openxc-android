package com.openxc.measurements;

import com.openxc.units.State;

import com.openxc.util.AgingData;
import com.openxc.units.Boolean;

/**
 * A DoorStatus represents a door's ajar status.
 *
 * This measurement is only valid when used asynchronously, much like any other
 * key or button event in Java. An application registers to receive button
 * events, and decides what to do based on the returned ButtonId and
 * ButtonAction.
 *
 * TODO would you want to be able to query for a specific door's state
 * synchronously?
 */
public class VehicleDoorStatus
        extends BaseMeasurement<State<VehicleDoorStatus.DoorId>> {
    public final static String ID = "door_status";

    /**
     * The DoorId is the specific door of the vehicle.
     */
    public enum DoorId {
        DRIVER,
        PASSENGER,
        REAR_LEFT,
        REAR_RIGHT,
        BOOT;

        private final int mHashCode;

        private DoorId() {
            mHashCode = toString().hashCode();
        }

        public int getHashCode() {
            return mHashCode;
        }

        public static DoorId fromHashCode(int hashCode) {
            for(DoorId position : DoorId.values()) {
                if(hashCode == position.getHashCode()) {
                    return position;
                }
            }
            throw new IllegalArgumentException(
                    "No valid door ID for hash code " + hashCode);
        }
    }

    public VehicleDoorStatus(State<DoorId> value, Boolean event) {
        super(value, event);
    }

    public VehicleDoorStatus(DoorId value, Boolean event) {
        this(new State<DoorId>(value), event);
    }

    public VehicleDoorStatus(Double value, Double event) {
        this(DoorId.fromHashCode(value.intValue()), new Boolean(event));
    }

    @Override
    public Boolean getEvent() {
        return (Boolean) super.getEvent();
    }

    @Override
    public java.lang.Boolean getSerializedEvent() {
        return new java.lang.Boolean(getEvent().booleanValue());
    }

    @Override
    public String getSerializedValue() {
        return getValue().enumValue().toString();
    }
}
