#!/usr/bin/env bash
set -euo pipefail

# Usage: ./build.sh [debug|release|bundle] [project_dir]
BUILD_TYPE="${1:-debug}"
PROJECT_DIR="${2:-.}"

cd "$PROJECT_DIR"

if [ ! -f "./gradlew" ]; then
    echo "Error: gradlew not found in $PROJECT_DIR" >&2
    exit 1
fi

chmod +x ./gradlew

case "$BUILD_TYPE" in
    debug)
        ./gradlew assembleDebug
        OUT_DIR="app/build/outputs/apk/debug"
        ;;
    release)
        ./gradlew assembleRelease
        OUT_DIR="app/build/outputs/apk/release"
        ;;
    bundle)
        ./gradlew bundlePlaybundle
        OUT_DIR="app/build/outputs/bundle/release"
        ;;
    *)
        echo "Error: unknown build type '$BUILD_TYPE'. Use debug, release, or bundle." >&2
        exit 1
        ;;
esac

echo "Build finished. Output in: $OUT_DIR"
find "$OUT_DIR" -type f \( -name "*.apk" -o -name "*.aab" \) 2>/dev/null