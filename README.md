# hello-kotlin
Micronaut Kotlin sample using Reactive libraries

#### If response is not streaming:

**Reactor:**

curl http://localhost:8080/postsMono
```
[{"id":1,"title":"Post 1"},{"id":2,"title":"Post 2"},{"id":3,"title":"Post 3"}]
```

**RxJava:**

curl http://localhost:8080/postsSingle
```
[{"id":1,"title":"Post 1"},{"id":2,"title":"Post 2"},{"id":3,"title":"Post 3"}]
```

**Kotlin Flow:**

curl http://localhost:8080/posts
```
[{"id":1,"title":"Post 1"},{"id":2,"title":"Post 2"},{"id":3,"title":"Post 3"}]
```

#### If response is streaming:

**Reactor:**

curl http://localhost:8080/commentsFlux
```
{"id":1,"text":"Latest Comment at 2020-02-09T19:01:42.994-06:00[America/Chicago]"}{"id":2,"text":"Latest Comment at 2020-02-09T19:01:45.006-06:00[America/Chicago]"}{"id":3,"text":"Latest Comment at 2020-02-09T19:01:45.608-06:00[America/Chicago]"}{"id":4,"text":"Latest Comment at 2020-02-09T19:01:46.210-06:00[America/Chicago]"}{"id":5,"text":"Latest Comment at 2020-02-09T19:01:46.813-06:00[America/Chicago]"}
```

**RxJava:**

curl http://localhost:8080/commentsFlowable
```
{"id":1,"text":"Latest Comment at 2020-02-09T19:02:43.417-06:00[America/Chicago]"}{"id":2,"text":"Latest Comment at 2020-02-09T19:02:44.422-06:00[America/Chicago]"}{"id":3,"text":"Latest Comment at 2020-02-09T19:02:45.023-06:00[America/Chicago]"}{"id":4,"text":"Latest Comment at 2020-02-09T19:02:45.625-06:00[America/Chicago]"}{"id":5,"text":"Latest Comment at 2020-02-09T19:02:46.229-06:00[America/Chicago]"}
```

**Kotlin Flow: (fixme)**

curl http://localhost:8080/comments
```

```