package util;

import constants.OutputConstants;
import exception.InvalidInputException;
import model.Command;
import model.Range;

import java.util.Arrays;
import java.util.List;

import static constants.OutputConstants.INVALID_START_TIME;

public class DurationParserUtil {

    public static Range parse(String startTime, String endTime) {

        if(startTime == null || endTime == null)
            throw new InvalidInputException(OutputConstants.INVALID_DURATION);

        Integer start = Integer.valueOf(startTime);
        Integer end = Integer.valueOf(endTime);

        if(start >= end)
            throw new InvalidInputException(INVALID_START_TIME);

        Range duration = new Range(start,end);

        return duration;
    }
}
