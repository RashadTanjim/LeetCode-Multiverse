import json
import matplotlib.pyplot as plt
import numpy as np
import re

# Path to your JSON file
json_path = "stats.json"

# Load LeetCode stats from the JSON file
with open(json_path, "r") as f:
    data = json.load(f)
    solved = data["leetcode"]["solved"]
    problems = data["leetcode"]["shas"]

# Categorize problems by difficulty
difficulty_count = {"Easy": 0, "Medium": 0, "Hard": 0}
problem_labels = {"Easy": [], "Medium": [], "Hard": []}

for problem, details in problems.items():
    if details.get("difficulty") and details.get("sha"):
        difficulty = details["difficulty"].capitalize()
        difficulty_count[difficulty] += 1
        problem_labels[difficulty].append(problem)

# Define chart colors
colors = {'Easy': '#76c7c0', 'Medium': '#ffb347', 'Hard': '#ff6961'}

# Create a figure with two subplots
fig, axes = plt.subplots(1, 2, figsize=(14, 6))

# Pie Chart: Distribution of Problem Difficulties
labels = list(difficulty_count.keys())
sizes = list(difficulty_count.values())
explode = (0.1, 0.1, 0.1)  

axes[0].pie(sizes, explode=explode, labels=labels, colors=[colors[l] for l in labels], 
            autopct='%1.1f%%', shadow=True, startangle=140, textprops={'fontsize': 12})
axes[0].set_title(f"LeetCode Stats: {solved} Problems Solved", fontsize=14)

# Bar Chart: Individual Problems
x_labels = []
y_values = []
bar_colors = []

for idx, (difficulty, problems) in enumerate(problem_labels.items()):
    x_labels.extend(problems)
    y_values.extend([idx] * len(problems))  # Assign each problem to its difficulty level
    bar_colors.extend([colors[difficulty]] * len(problems))

y_positions = np.arange(len(x_labels))

axes[1].barh(y_positions, y_values, color=bar_colors)
axes[1].set_yticks(y_positions)
axes[1].set_yticklabels(x_labels, fontsize=10)
axes[1].set_xlabel("Difficulty Levels")
axes[1].set_title("Problems Solved by Category", fontsize=14)

# Adjust layout and save image
plt.tight_layout()
image_path = "leetcode_stats.png"
plt.savefig(image_path)
plt.close()

# Update the README.md file
readme_path = "README.md"

# Read the existing content
with open(readme_path, "r") as f:
    readme_content = f.read()

# Remove any existing image tag
readme_content = re.sub(r'<img src="leetcode_stats.png".*?>\n\n', '', readme_content)

# Append the new image at the bottom
image_html = f'\n\n<img src="{image_path}" alt="LeetCode Stats" width="600">\n'
updated_content = readme_content.strip() + image_html  # Ensures there's no trailing spaces

# Write back to the README file
with open(readme_path, "w") as f:
    f.write(updated_content)

print(f"Updated README.md and saved chart as {image_path}")
