package jpuppeteer.cdp.client.entity.media;

/**
* Called whenever a player is created, or when a new agent joins and receives a list of active players. If an agent is restored, it will receive the full list of player ids and all events again.
* experimental
*/
public class PlayersCreatedEvent {

    /**
    */
    private java.util.List<String> players;

    public void setPlayers (java.util.List<String> players) {
        this.players = players;
    }

    public java.util.List<String> getPlayers() {
        return this.players;
    }

    public PlayersCreatedEvent(java.util.List<String> players) {
        this.players = players;
    }

    public PlayersCreatedEvent() {
    }

}