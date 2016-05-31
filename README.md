# DIDemo
A Java *dependency-injection-framework demo*. Just like springmvc, but it is quite simple.

Using java reflection, the framework(if it could be called a framework...) has a capability for auto injecting all beans annotated
with `@Inject` annotation. And beans, annotated with `@Dependent`, which are set as fields in a specific class could be also auto
injected and be initialized with registered instance.

