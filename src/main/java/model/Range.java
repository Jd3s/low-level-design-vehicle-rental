package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Range {
    private int startTime;
    private int endTime;

    public Range(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getNumberOfHours() {
       return this.endTime- this.startTime;
    }
}
