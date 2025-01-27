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

# Generate the chart
labels = ['Easy', 'Medium', 'Hard']
sizes = [easy, medium, hard]
colors = ['#76c7c0', '#ffb347', '#ff6961']
explode = (0.1, 0.1, 0.1)

plt.figure(figsize=(8, 8))
plt.pie(
    sizes,
    explode=explode,
    labels=labels,
    colors=colors,
    autopct='%1.1f%%',
    shadow=True,
    startangle=140,
    textprops={'fontsize': 14}
)
plt.title(f"LeetCode Stats: {solved} Problems Solved", fontsize=16)

# Save the graph as an image
image_path = "leetcode_stats.png"
plt.savefig(image_path)
plt.close()

# Update the README.md file
readme_path = "README.md"

with open(readme_path, "r") as f:
    readme_content = f.readlines()

# Find the position after the first two lines
line1 = "# LeetCode-Multiverse\n"
line2 = "Collection of LeetCode questions & solutions.\n"
image_html = f'<img src="{image_path}" alt="LeetCode Stats" width="400">\n\n'

# Update content to insert image after the two lines
if line1 in readme_content and line2 in readme_content:
    index = readme_content.index(line2) + 1
    updated_content = readme_content[:index] + [image_html] + readme_content[index:]
else:
    # If the lines are not found, prepend the image as fallback
    updated_content = [image_html] + readme_content

# Write back the updated content to the README file
with open(readme_path, "w") as f:
    f.writelines(updated_content)
