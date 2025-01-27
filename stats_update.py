import json
import matplotlib.pyplot as plt

# Path to your JSON file
json_path = "stats.json"

# Load LeetCode stats from the JSON file
with open(json_path, "r") as f:
    data = json.load(f)
    solved = data["leetcode"]["solved"]
    easy = data["leetcode"]["easy"]
    medium = data["leetcode"]["medium"]
    hard = data["leetcode"]["hard"]

# Calculate unsolved problems for additional context
total_problems = data["leetcode"]["total"]
unsolved = total_problems - solved

# Generate the chart with additional details
labels = [f'Easy ({easy})', f'Medium ({medium})', f'Hard ({hard})', f'Unsolved ({unsolved})']
sizes = [easy, medium, hard, unsolved]
colors = ['#76c7c0', '#ffb347', '#ff6961', '#d3d3d3']  # Light gray for unsolved
explode = (0.1, 0.1, 0.1, 0)  # Emphasize solved categories

plt.figure(figsize=(10, 10))
plt.pie(
    sizes,
    explode=explode,
    labels=labels,
    colors=colors,
    autopct=lambda p: f'{p:.1f}%\n({int(p * total_problems / 100)} problems)',
    shadow=True,
    startangle=140,
    textprops={'fontsize': 12}
)
plt.title(f"LeetCode Stats: {solved}/{total_problems} Problems Solved", fontsize=16)

# Save the graph as an image
image_path = "leetcode_stats.png"
plt.savefig(image_path)
plt.close()

# Update the README.md file
readme_path = "README.md"
with open(readme_path, "r") as f:
    readme_content = f.readlines()

# Insert the graph image after the first two lines in the README
line1 = "# LeetCode-Multiverse\n"
line2 = "Collection of LeetCode questions & solutions.\n\n"
image_html = f'<img src="{image_path}" alt="LeetCode Stats" width="400">\n\n'

if line1 in readme_content and line2 in readme_content:
    index = readme_content.index(line2) + 1
    updated_content = readme_content[:index] + [image_html] + readme_content[index:]
else:
    updated_content = [image_html] + readme_content

# Write the updated content back to the README
with open(readme_path, "w") as f:
    f.writelines(updated_content)
