package ui;

import sim.Player;
import sim.Team;
import media.NewsStory;

import java.util.List;

public class MediaHubUI {

    public void displayTopStories(List<NewsStory> stories) {
        System.out.println("📰 Media Hub - Top Headlines:");
        for (NewsStory story : stories) {
            System.out.println("• [" + story.getDate() + "] " + story.getHeadline());
        }
    }

    public void featurePlayer(Player player) {
        System.out.println("🎙️ Media spotlight on " + player.getName());
        System.out.println("Reputation: " + player.getReputation() + " | Brand: " + player.getBrand());
    }

    public void teamNews(Team team) {
        System.out.println("📣 Latest buzz about " + team.getName());
        // You could pull team-related news stories from a simulated feed here
    }
}
