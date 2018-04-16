Command Pattern Important Points
<ul>
<li>Command is the core of command design pattern that defines the contract for implementation.</li>
<li>Receiver implementation is separate from command implementation.</li>
<li>Command implementation classes chose the method to invoke on receiver object, for every method in receiver there will be a command implementation. It works as a bridge between receiver and action methods.</li>
<li>Invoker class just forward the request from client to the command object.</li>
<li>Client is responsible to instantiate appropriate command and receiver implementation and then associate them together.</li>
<li>Client is also responsible for instantiating invoker object and associating command object with it and execute the action method.</li>
<li>Command design pattern is easily extendible, we can add new action methods in receivers and create new Command implementations without changing the client code.</li>
<li>The drawback with Command design pattern is that the code gets huge and confusing with high number of action methods and because of so many associations.</li>
</ul>