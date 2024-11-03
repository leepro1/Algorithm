package programmers;

public class P340213 {

    static int videoSecond, posSecond, opStartSecond, opEndSecond;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        videoSecond = toSeconds(video_len);
        posSecond = toSeconds(pos);
        opStartSecond = toSeconds(op_start);
        opEndSecond = toSeconds(op_end);

        skipOpening();

        for (String command : commands) {

            if ("prev".equals(command)) {
                posSecond = Math.max(0, posSecond - 10);
            } else {
                posSecond = Math.min(videoSecond, posSecond + 10);
            }

            skipOpening();
        }

        return toTimeFormat();
    }

    // 시간을 초 단위로 변환하는 메서드
    private int toSeconds(String time) {
        String[] split = time.split(":");

        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    // 초를 "MM:SS" 형식으로 변환하는 메서드
    private String toTimeFormat() {
        int minutes = posSecond / 60;
        int seconds = posSecond % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    // opening을 건너뛰는 메서드
    private void skipOpening() {
        if (posSecond >= opStartSecond && posSecond <= opEndSecond) {
            posSecond = opEndSecond;
        }
    }
}