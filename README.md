# BroadBoard

An Android IME keyboard designed for low vision users

[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](LICENSE)
[![Get it on Google Play](https://img.shields.io/badge/Google%20Play-available-brightgreen)](https://play.google.com/store/apps/details?id=com.galagidae.broadboard)

## Screenshots

| Standard                                                                      | High Contrast                                                                 | Settings                                                                      |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| ![screenshot1](fastlane/metadata/android/en-US/images/phoneScreenshots/1.png) | ![screenshot2](fastlane/metadata/android/en-US/images/phoneScreenshots/2.png) | ![screenshot3](fastlane/metadata/android/en-US/images/phoneScreenshots/3.png) |

## Features

- Large, scrollable keyboard
- Different size options
- Haptic feedback option
- No network access, no data sharing

## Installation

### Google Play

<a href="https://play.google.com/store/apps/details?id=com.galagidae.broadboard">
  <img src="https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png" alt="Get it on Google Play" height="80">
</a>

## Setting up the keyboard

After installing, BroadBoard must be enabled and selected as your input method:

1. Go to **Settings → System → Languages & input → On-screen keyboard → Manage keyboards**
2. Enable **BroadBoard**
3. Switch to it via the keyboard picker (tap the keyboard icon in the navigation bar, or long-press the spacebar in most apps). Alternatively, launching BroadBoard from the app tray provides a link to the keyboard picker.

## Building from source

This project is built with the Gradle command-line tools (no Android Studio required).

```bash
git clone https://github.com/galagidae/broadboard.git
cd broadboard

# Debug build
./build.sh

# Release build
./build.sh release
```

Requirements:

- JDK 17
- Android SDK with platform 36 and build-tools 36 installed (`sdkmanager` is sufficient – Android Studio is not needed)

## Privacy

BroadBoard collects no data.

See [PRIVACY.md](PRIVACY.md) for details.

## License

This project is licensed under the **GNU General Public License v3.0**.

```
Copyright (C) 2026 Anthony Benbrook

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
```

See [LICENSE](LICENSE) for the full text.
