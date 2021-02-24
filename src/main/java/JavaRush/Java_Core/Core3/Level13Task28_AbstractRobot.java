package JavaRush.Java_Core.Core3;

public abstract class Level13Task28_AbstractRobot implements Level13Task28_Attackable, Level13Task28_Defensable {

    private static int hitCount = 1;

    public abstract String getName();

    public Level13Task28_BodyPart attack() {
        Level13Task28_BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            attackedBodyPart = Level13Task28_BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = Level13Task28_BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = Level13Task28_BodyPart.LEG;
        }
        else if (hitCount >= 4) {
            hitCount = 0;
            attackedBodyPart = Level13Task28_BodyPart.CHEST;
        }
        System.out.println(hitCount);
        return attackedBodyPart;
    }
    public Level13Task28_BodyPart defense() {
        Level13Task28_BodyPart defendedBodyPart = null;
        hitCount = hitCount + 2;

        if (hitCount == 1) {
            defendedBodyPart = Level13Task28_BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = Level13Task28_BodyPart.LEG;
        } else if (hitCount == 3) {
            defendedBodyPart = Level13Task28_BodyPart.ARM;
        } else if (hitCount >= 4){
            hitCount = 0;
            defendedBodyPart = Level13Task28_BodyPart.CHEST;
        }
        System.out.println(hitCount);
        return defendedBodyPart;
    }
}
