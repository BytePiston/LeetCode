<h2><a href="https://www.codingninjas.com/studio/problems/ninja-s-training_3621003">Dynamic Programming: Ninja’s Training</a></h2><h3>Medium</h3><hr><div>

<p>Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?

You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3]]
<strong>Output:</strong> 11
<strong>Explanation:</strong>
Pick Task-3: (5) from Day 0, Task-1: (3) from Day 1, Task-3: (3) from Day 3;
The answer will be 5 + 3 + 3 = 11.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 <= T <= 10</code></li>
	<li><code>1 <= N <= 100000</code></li>
	<li><code>1 <= values of POINTS arrays <= 100 </code></li>
</ul>
