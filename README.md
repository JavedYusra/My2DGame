# 2D Tile-Based Game (Java)

A simple 2D tile-based game engine written in Java using `Graphics2D`.  
The project is inspired by classic retro games (like Zelda or Pokémon) and serves as a learning project for building tile maps, handling collisions, and rendering game objects.

---

## Features
- Tile-based world rendering system  
  - `0 = Grass`  
  - `1 = Wall`  
  - `2 = Water`  
- Map loading from `.txt` files  
- Customizable tile graphics (`.png` images)  
- Game loop with `GamePanel`  
- Easy to extend with more tiles, objects, and mechanics  

---

## Map Example

Map text files are stored in `res/maps/`.

Example (`map01.txt`):

1 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 <br>
1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1<br>
1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1<br>
1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1<br>
1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1<br>
1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1<br>
1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1<br>
1 0 0 0 0 0 2 2 2 2 0 0 0 0 0 1<br>
1 0 0 0 0 0 2 2 2 2 0 0 0 0 0 1<br>
1 0 0 0 0 0 2 2 2 2 0 0 0 0 0 1<br>
1 0 0 0 0 0 2 2 2 2 0 0 0 0 0 1<br>
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1<br>



---

## Assets

Tile images are located in `res/tiles/`:

- `grass.png`  
- `wall.png`  
- `water.png`  

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/JavedYusra/My2DGame.git

