# Bowling
### General Information
* A bowling game is split into 10 frames
* Each frame contains 2 rolls
* Your score for any given frame is the sum of the number of pins you knocked down with each of those rolls
* Special Case 1: If you knock down all 10 pins with 2 balls, this is called a Spare. Spares are scored by 
    taking 10 (the 10 pins that you knock down) and adding the number of pins you knock down with your very next throw.
    For example, take a game where you knock down 5, 5, and then 3 would be scored as a 13 for the first frame.
* Special Case 2: When you knock down all 10 pins with your first throw in a frame. This is called a Strike. Strikes are scored as 10 + the number of pins you knocked down with the next 2 throws. So for example imagine you got a strike, followed by a 3, and another 3 - your score for the first frame would be the following: 10 + 3 + 3 = 16
*  In the 10th frame it is possible to get a Spare or a Strike. In that case, to figure out what the score for the tenth frame is, you need to throw additional balls.
* If you got a Spare in the 10th frame: You need to throw 1 additional time to complete the Spare.
* If you got a Strike in the 10th frame: You need to throw 2 more times to calculate the score for that Strike.

