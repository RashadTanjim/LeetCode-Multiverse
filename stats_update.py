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
plt.pie(sizes, explode=explode, labels=labels, colors=colors, autopct='%1.1f%%',
        shadow=True, startangle=140, textprops={'fontsize': 14})
plt.title(f"LeetCode Stats: {solved} Problems Solved", fontsize=16)

# Save the graph as an image
image_path = "leetcode_stats.png"
plt.savefig(image_path)
plt.close()

# Update the README.md file
readme_path = "README.md"
with open(readme_path, "r") as f:
    readme_content = f.readlines()

# Add the graph image at the top with smaller size using HTML
with open(readme_path, "w") as f:
    image_html = f'<img src="{image_path}" alt="LeetCode Stats" width="400">\n\n'
    updated_content = readme_content + "\n\n" + [image_html]
    f.writelines(updated_content)
