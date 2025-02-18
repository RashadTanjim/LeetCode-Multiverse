import json
import matplotlib.pyplot as plt

# Load LeetCode stats
with open("stats.json", "r") as f:
    data = json.load(f)
    solved = data["leetcode"]["solved"]
    problems = data["leetcode"]["shas"]

# Count difficulties
difficulty_count = {"Easy": 0, "Medium": 0, "Hard": 0}
for details in problems.values():
    if details.get("difficulty"):
        difficulty = details["difficulty"].capitalize()
        difficulty_count[difficulty] += 1

# Generate a well-styled pie chart
plt.figure(figsize=(6, 6))
plt.pie(difficulty_count.values(), labels=difficulty_count.keys(), autopct='%1.0f%%',
        colors=['#76c7c0', '#ffb347', '#ff6961'], startangle=140, wedgeprops={'edgecolor': 'white', 'linewidth': 2})
plt.title(f"LeetCode: {solved} Problems Solved", fontsize=14, fontweight='bold')
plt.savefig("leetcode_stats.png", bbox_inches='tight', dpi=300)
plt.close()

print("Generated well-styled LeetCode stats chart.")
