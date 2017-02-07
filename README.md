##Spring Cloud Contract

###consumer-driven contract testing
what makes it "consumer-based"? the consumer writes a test against a service it uses to confirm that the service contract satisfies the consumer needs.

why driven from consumer side? it's hard to sustain and evolve, say, an API if it keeps changing its service based on every consumer's need. when client-centric tests are created *by* the client, the service can better understand how clients use their APIs. consumers generate these contract tests to document their expectations and service owner incorporates them into the service's test suite.  

```
the set of integration tests received from all existing clients represents the service's aggregate obligations with respect to its client base. The service owner is then free to change and evolve the service just so long as the existing integration tests continue to pass.
```

###components
1. Spring RestDocs
- generate stubs *and* adocs
1. Spring Cloud Verifier
- producer defines contract using Groovy DSL and auto-generates server-side acceptance/contract test
- once test passes, stubs are produced (to be used by Wiremock or other HTTP stub server) to be used for tests on client side
1. SCC Stub Runner
- on consumer side, auto download stubs
- `@AutoConfigureStubRunner`
- uses Wiremock as stub server. include JSON stubs in classpath or use `MockRestServiceServer` to load JSON files as WireMock stubs

###common workflow

C = consumer. S = service

1. C writes a test for new feature (new endpoint on S). obviously, it'll fail.
1. C clones the S's repo. in there, C defines contract (in Groovy DSL) and runs Verifier to generate stubs. 
    - skip tests since that's S's job to make them pass
    - make sure Verifier publishes stubs jar since that's all C wants to play with.
1. C goes back to its own repo. use `Stub Runner` to start a server for S app with the stubs it just published. set Stub Runner's mode to `workOffline`.
1. once satisfied with contract and stubs, C sends PR to S's repo.
1. S sees PR. uses `Rest Assured MVC` to start the server side controller. use Verifier plugin to generate tests (failing for now). write the missing implementation. push the changes. 
1. C can now disable `workOffline` so it can pick up latest stub from artifactory.