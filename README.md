# MarsRover (Problem statement)

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth. A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North. In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

INPUT:
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

OUTPUT:
The output for each rover should be its final co-ordinates and heading.

INPUT AND OUTPUT:
Test Input:
5 5

1 2 N

LMLMLMLMM

3 3 E

MMRMMRMRRM

Expected Output:
1 3 N

5 1 E

## Test Report

![WhatsApp Image 2024-05-19 at 15 03 23_2b697404](https://github.com/ashokpawar25/MarsRover/assets/117933840/773b8d5c-94c5-4e60-8ff3-af602fe71a5b)

## Process
- Create rover
- Create plateau
- Deploy rover on plateau
- Give instructions to rover
- Get final position and direction of rover

# domain Package - It consist domain models and domain services
## domain.model.entity Package - It consist all the entities

## RoverDto
### States
- `private final int id`
- `private boolean isDeployed`

### Constructors
- `public RoverDto(int id)`

### Behaviors
- `getters and setters`

## DeployedRoverDto
### States
- `private final int id`
- `private Coordinate coordinate`
- `private Direction direction`

### Constructors
- `public DeployedRoverDto(int id, Coordinate coordinate, Direction direction)`

### Behaviors
- `getters and setters`

## PlateauDto
### States
- `private final int id`
- `private final int length`
- `private final int breadth`
- `private List<DeployedRoverDto> deployedRovers`

### Constructors
- `public PlateauDto(int id, int length, int breadth)`
- `public static PlateauDto create(int id, int length, int breadth)`

### Behaviors
- `getters and setters`

## domain.model.valueobject Package - It consist value object classes

## Coordinate
### States
- `private int x`
- `private int y`

### Constructors
- `public Coordinate(int x, int y)`

### Behaviors
- `getters and setters`

## Direction (enum)
### States
- `N`
- `E`
- `S`
- `W`

### Behaviors
- `public Direction getLeft()`
- `public Direction getRight()`

## Instruction
### States
- `R`
- `L`
- `M`

## domain.model.service Package - This package having domain service classes

## InstructionProcessor
### Behaviors
- `public static DeployedRoverDto process(String rawInstruction, DeployedRoverDto rover)`
- `private static void moveRover(DeployedRoverDto rover)`

## RoverController
### States
- `private final RoverService roverService`

### Constructors
- `public RoverController(RoverService roverService)`

# controller Package - This package having controller classes

### Behaviors
- `public Response create()`
- `public RoverDto find(int id)`

## PlateauController
### States
- `private final PlateauService plateauService`

### Constructors
- `public PlateauController(PlateauService plateauService)`

### Behaviors
- `public Response create(int length, int breadth)`
- `public PlateauDto find(int id)`
- `public Response deployRover(int roverId, int plateauId, Coordinate coordinate, Direction direction)`

## InstructionController
### States
- `private final InstructionService instructionService`

### Constructors
- `public InstructionController(InstructionService instructionService)`

### Behaviors
- `public DeployedRoverDto processInstructions(int roverId, int plateauId, String instructions)`

## controller.dto Package - This package consist class to return http status from the controller methods
## Response
### States
- `private final HttpStatus httpStatus`
- `private final String message`

### Constructors
- `public Response(HttpStatus httpStatus, String message)`

## HttpStatus
### Enum Values
- `BAD_REQUEST`
- `OK`

# service Package - Classes from this package are the middalware between controller layer and repository layer

## RoverService
### States
- `private final RoverRepository roverRepository`

### Constructors
- `public RoverService(RoverRepository roverRepository)`

### Behaviors
- `public RoverDto create()`
- `public RoverDto find(int id)`

## PlateauService
### States
- `private final PlateauRepository plateauRepository`
- `private final RoverService roverService`

### Constructors
- `public PlateauService(PlateauRepository plateauRepository, RoverService roverService)`

### Behaviors
- `public PlateauDto create(int length, int breadth)`
- `public PlateauDto find(int id)`
- `public PlateauDto deployRover(int roverId, int plateauId, Coordinate coordinate, Direction direction)`

## InstructionService
### States
- `private final PlateauService plateauService`

### Constructors
- `public InstructionService(PlateauService plateauService)`

### Behaviors
- `public DeployedRoverDto processInstructions(int roverId, int plateauId, String instruction)`

# Repository Package - Classes from this package interact with the database, performing operations requested by the services.

## InMemoryRoverRepository
### States
- `private final InMemoryDatabase inMemoryDatabase`

### Constructors
- `public InMemoryRoverRepository(InMemoryDatabase inMemoryDatabase)`

### Behaviors
- `public RoverDto add()`
- `public RoverDto find(int id)`

## InMemoryPlateauRepository
### States
- `private final InMemoryDatabase inMemoryDatabase`

### Constructors
- `public InMemoryPlateauRepository(InMemoryDatabase inMemoryDatabase)`

### Behaviors
- `public PlateauDto add(int length, int breadth)`
- `public PlateauDto find(int id)`

## FakeInMemoryDatabase
### States
- `private List<RoverDto> rovers`
- `private List<PlateauDto> plateauDtos`
- `private int roverIdCounter`
- `private int plateauIdCounter`

### Behaviors
- `public RoverDto insertIntoRoverTable()`
- `public RoverDto selectFromRoverTable(int id)`
- `public PlateauDto insertIntoPlateauTable(int length, int breadth)`
- `public PlateauDto selectFromPlateauTable(int id)`
