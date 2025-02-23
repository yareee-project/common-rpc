#!/bin/bash
set -e

echo "🔹 Running build for repository: $REPO_NAME"

# Run Gradle Build
cd $REPO_NAME
./gradlew clean build --no-daemon

echo "✅ Build completed successfully."
