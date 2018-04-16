<p>
<a href="#" alt="Strategy Pattern, Strategy Design pattern in java" width="450" height="261">
<img src="./main/resources/Strategy-Pattern-450x261.png" alt="Strategy Pattern, Strategy Design pattern in java" width="450" height="261">
</a>
</p>
<h3>Strategy Design Pattern Important Points</h3>
<ul>
<li>We could have used composition to create instance variable for strategies but we should avoid that as we want the specific strategy to be applied for a particular task. Same is followed in Collections.sort() and Arrays.sort() method that take comparator as argument.</li>
<li>Strategy Pattern is very similar to <strong><a href="https://www.journaldev.com/1751/state-design-pattern-java" title="State Design Pattern in Java – Example Tutorial">State Pattern</a></strong>. One of the difference is that Context contains state as instance variable and there can be multiple tasks whose implementation can be dependent on the state whereas in strategy pattern strategy is passed as argument to the method and context object doesn’t have any variable to store it.</li>
<li>Strategy pattern is useful when we have multiple algorithms for specific task and we want our application to be flexible to chose any of the algorithm at runtime for specific task.</li>
</ul>