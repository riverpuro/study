package state;

public class LunchState implements State {
    private static LunchState singleton = new LunchState();

    private LunchState() {
    }

    public static LunchState getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 12 || 13 < hour) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("非常: 昼食時の金庫使用！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(昼食時)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("昼食時の通話録音");
    }

    @Override
    public String toString() {
        return "[昼食時]";
    }
}