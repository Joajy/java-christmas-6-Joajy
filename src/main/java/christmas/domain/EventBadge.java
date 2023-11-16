package christmas.domain;

import static christmas.util.OutputConstant.*;
import static christmas.util.OutputConstant.NORMAL_BADGE;

public enum EventBadge {
    산타("산타", 20000),
    별("별", 10000),
    트리("트리", 5000);

    EventBadge(String membership, int amount) {
    }

    public static String getEventBadge(int money) {
        if (money >= VVIP_PRICE) {
            return VVIP_BADGE;
        }
        if (money >= VIP_PRICE) {
            return VIP_BADGE;
        }
        if (money >= NORMAL_PRICE) {
            return NORMAL_BADGE;
        }
        return NOTHING;
    }
}
