package io.github.jonthesquirrel.actionbartimer;

import java.time.Duration;

import static org.apache.commons.lang.time.DurationFormatUtils.formatDurationWords;

class Formatter {
    static String format(Duration d) {
        return formatDurationWords(d.toMillis(), true, true);
    }
    static Duration parse(String s) {
        return Duration.ofSeconds(Duration.parse("PT" + s).getSeconds());
//        round off any milliseconds
    }
}
