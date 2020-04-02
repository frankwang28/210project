package model;

public class CollisionChecker {

    private Player player;
    private ObstaclesList obstaclesList;

    // EFFECTS: Creates a collision checker
    public CollisionChecker(Player p, ObstaclesList ol) {
        player = p;
        obstaclesList = ol;
    }

    // EFFECTS: checks for collision of an obstacle and the player
    public boolean checkCollision() {
        for (Obstacle obj : obstaclesList.obstacleList) {
            int top = obj.posY - obj.height / 2;
            int bot = obj.posY + obj.height / 2;
            int lef = obj.posX - obj.width / 2;
            int rig = obj.posX + obj.width / 2;
            int playerTop = player.ypos - player.height / 2;
            int playerBot = player.ypos + player.height / 2;
            int playerLef = Player.XPOS - player.width / 2;
            int playerRig = Player.XPOS + player.width / 2;
            if ((((top > playerTop) && (playerBot > top)) || ((bot > playerTop) && (playerBot > bot)))
                    && (((lef > playerLef) && (playerRig > lef)) || ((rig > playerLef) && (playerRig > rig)))
            ) {
                return true;
            }
        }
        return false;
    }
}
