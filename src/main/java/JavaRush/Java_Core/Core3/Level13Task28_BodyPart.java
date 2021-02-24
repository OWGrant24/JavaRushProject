package JavaRush.Java_Core.Core3;

public final class Level13Task28_BodyPart {
    final static Level13Task28_BodyPart LEG = new Level13Task28_BodyPart("нога");
    final static Level13Task28_BodyPart HEAD = new Level13Task28_BodyPart("голова");
    final static Level13Task28_BodyPart ARM = new Level13Task28_BodyPart("рука");
    final static Level13Task28_BodyPart CHEST = new Level13Task28_BodyPart("грудь");

    private String bodyPart;

    private Level13Task28_BodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return this.bodyPart;
    }
}
