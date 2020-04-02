# Dodger

## A game based on dodging obstacles 

Intended features:
- A **player controlled** object that can move in a single dimension.
- Various **obstacles** that are generated and move across the screen. 
- **Increasing** difficulty as the game progresses. 

This game can be played by anyone who wants to. This project is of interest to me as I enjoy playing various games and
creating a game would be interesting insight into the process in creating such games.

#### User Stories
- As a user, I want to be able to move the controllable object up and down.
- As a user, I want to be able to have obstacles spawn.
- As a user, I want to be able to start the game.
- As a user, I want to be able to lose upon colliding with an obstacle.
- As a user, I want to be able to have my high score automatically saved upon losing.
- As a user, I want to be able to see my high score at the start of games. 

#### Instructions for Grader
- You can generate the first required event by using the up and down keys once the game has begun.
- You can generate the second required event by playing the game.
- You can generate the third event by entering 'S' once the GUI has loaded.
- You can generate the fourth event by colliding with an obstacle. 
- You can locate the visual component when running the game.
- You can see the save state of my application through the saving of new high scores. 
- You can see the load state of my application through the loading of high scores. 

#### Phase 4: Task 2

Implemented a type hierarchy.

The classes that played a role are as follows:
- Obstacle
- ObstacleLevel1
- ObstacleLevel2
- ObstacleLevel3

#### Phase 4: Task 3

- Improved cohesion by making the function in Game of checking for collision into a separate class: CollisionChecker. 
- Improved cohesion by making splitting the function in ObstaclesList of determining the level of the obstacles into a separate class: ObstacleListManager. 
- Reduced coupling in the Obstacle class and its subclasses by no longer referring to the Game class to get the height.
- Reduced coupling in the Player class by no longer referring to the Game class to get the height.  
- Reduced coupling in the Game class by no longer referring to the Game class to get the height and width.

Note for UML design: Dependencies are not shown (as it is not required). However, one dependency between GameUI and LoadScore is shown as that is the only relationship with LoadScore in the project.   