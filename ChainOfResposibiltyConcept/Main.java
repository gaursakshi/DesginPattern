package ChainOfResposibiltyConcept;

import ChainOfResposibiltyConcept.data.Request;

public class Main {
    public static void main(String[] args) {
        PlayVideoApi playVideoApi = new PlayVideoApi();
        playVideoApi.playVideo(new Request("header","body","token"));
    }
}
