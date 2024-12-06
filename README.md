# Analyzing GEMSEC Deezer Dataset using Apache Spark GraphX

## Overview
This project analyzes the **GEMSEC Deezer dataset** using **Apache Spark GraphX**, focusing on user friendship networks in Romania. The analysis applies key graph algorithms such as **PageRank**, **Triangle Counting**, and **Connected Components** to derive meaningful insights.

## Dataset Description
The GEMSEC Deezer dataset includes:
- **Nodes:** Representing users of the Deezer platform.
- **Edges:** Indicating mutual friendships between users.
- **Genre Preferences:** JSON files mapping user IDs to their liked genres.

### Romanian Subset Statistics
- **Nodes:** 41,773
- **Edges:** 125,826

### Dataset Source
[GEMSEC Deezer Dataset](https://snap.stanford.edu/data/gemsec-Deezer.html)

## Methodology
1. **Preprocessing:**
   - The dataset was prepared in an edge list format compatible with Apache Spark GraphX.
   - A directed graph was constructed using `GraphLoader`.

2. **Graph Analysis Algorithms:**
   - **PageRank:** Identifies influential users in the network.
   - **Connected Components:** Finds clusters of interconnected users.
   - **Triangle Counting:** Measures clustering and network interconnectedness.

3. **Technology Stack:**
   - Apache Spark GraphX
   - Java for implementing algorithms and creating GraphFrames

## Files in the Project
- **`ro.txt`:** The dataset file for the Romanian subset.
- **`pom.xml`:** The dependencies file for the project.
- **`Main.java`:** The primary code file where graph processing was implemented.
- **`Edge.java` and `Vertex.java`:** Supporting classes used in `Main.java` for creating GraphFrames.

## Algorithms and Results
### 1. PageRank
- **Purpose:** Ranks users by their influence in the network.
- **Result:** 
  - User **4904** has the highest PageRank, indicating they are the most influential and followed user.

### 2. Triangle Counting
- **Purpose:** Counts triangles (mutual friendships) in the network.
- **Result:**
  - User **26** forms the most triangles, showing strong clustering and interconnectedness.

### 3. Connected Components
- **Purpose:** Identifies cohesive clusters of users.
- **Result:**
  - All users are connected in a single graph, indicating that all users belong to a single connected component. The count of connected components is **0**.



## Conclusion
- **PageRank:** User **4904** is the most influential user in the Romanian subset of the network.
- **Triangle Counting:** User **26** has the highest clustering, forming the most triangles.
- **Connected Components:** The network is fully connected, forming a single graph.


## References
1. [GEMSEC Deezer Dataset](https://snap.stanford.edu/data/gemsec-Deezer.html)
2. [Apache Spark GraphX Documentation](https://spark.apache.org/docs/latest/graphx-programming-guide.html)
3. [PageRank Algorithm](https://en.wikipedia.org/wiki/PageRank)
4. [Graph Algorithms](https://en.wikipedia.org/wiki/Graph_(abstract_data_type))

## Team Members
- **Vansh Lal Tolani** (22bds061@iiitdwd.ac.in)
- **Rajdeep Manik** (22bds048@iiitdwd.ac.in)
- **G Leeladitya** (22bds024@iiitdwd.ac.in)
- **Shanmukha D** (22bds019@iiitdwd.ac.in)
