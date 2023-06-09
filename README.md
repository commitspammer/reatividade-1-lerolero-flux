# LeroLero - WebFlux Service Architecture v1

Note: All of the following service specifications are suggestions at best, and may be modified as seen fit.

## API Gateway

### Get random noun list

Generates a list of random nouns.
The size of the list is determined by the positive integer query paramater `{size}`.
If not specified, `{size}` defaults to 1.
The return value isn't a JSON Array, but a sequence of server-sent "message" events.

**Endpoint**:

```ts
GET /nouns?size={size}
```

**Returns**:
200 OK

```ts
data: string

data: string

...

data: string
```

### Subscribe for random noun events

Emits a random noun periodically and indefinitely.
The time interval is determined by the non-negative integer query paramater `{interval}`, for milliseconds.
If not specified, `{interval}` defaults to 200ms.
The return value is a text stream of server-sent "message" events.

**Endpoint**:

```ts
GET /nouns/events?interval={interval}
```

**Returns**:
200 OK

```ts
data: string

data: string

...

data: string
```

### Get random verb list

Analogous to ["Get random noun list"](#get-random-noun-list) route.

**Endpoint**:

```ts
GET /verbs?size={size}
```

**Returns**:
200 OK

```ts
data: string

data: string

...

data: string
```

### Subscribe for random verb events

Analogous to ["Subscribe for random noun events"](#subscribe-for-random-noun-events) route.

**Endpoint**:

```ts
GET /verbs/events?interval={interval}
```

**Returns**:
200 OK

```ts
data: string

data: string

...

data: string
```

### Get random adverb list

Analogous to ["Get random noun list"](#get-random-noun-list) route.

**Endpoint**:

```ts
GET /adverbs?size={size}
```

**Returns**:
200 OK

```ts
data: string

data: string

...

data: string
```

### Subscribe for random adverb events

Analogous to ["Subscribe for random noun events"](#subscribe-for-random-noun-events) route.

**Endpoint**:

```ts
GET /adverbs/events?interval={interval}
```

**Returns**:
200 OK

```ts
data: string

data: string

...

data: string
```
