## API proxy and cache for [WorldTimeAPI](http://worldtimeapi.org)

### Routing (port = 5678)
fetch data GET : `localhost:5678/time/{area}/{city}`

clear cache DELETE : `localhost:5678/time/clear`

#### abbreviation
`type: string`

the abbreviated name of the timezone

#### datetime
`type: string`

an ISO8601-valid string representing the current, local date/time

#### day_of_week
`type: integer`

current day number of the week, where sunday is 0

#### day_of_year
`type: integer`

ordinal date of the current year

#### dst
`type: bool`

flag indicating whether the local time is in daylight savings

#### dst_from
`type: string`

an ISO8601-valid string representing the datetime when daylight savings started for this timezone

#### dst_offset
`type: integer`

the difference in seconds between the current local time and daylight saving time for the location

#### dst_until
`type: string`

an ISO8601-valid string representing the datetime when daylight savings will end for this timezone

#### raw_offset
`type: integer`

the difference in seconds between the current local time and the time in UTC, excluding any daylight saving difference (see dst_offset)

#### timezone
`type: string`

timezone in Area/Location or Area/Location/Region format

#### unixtime
`type: integer`

number of seconds since the Epoch

#### utc_datetime
`type: string`

an ISO8601-valid string representing the current date/time in UTC

#### utc_offset
`type: string`

an ISO8601-valid string representing the offset from UTC

#### week_number
`type: integer`

the current week number