# Privacy Policy

**Last updated:** [2026-07-29]

This policy applies to BroadBoard (com.galagidae.broadboard), an Android input method (keyboard) application.

## Summary

BroadBoard does not collect, store, or transmit any user data. It has no network access and no third-party analytics, advertising, or crash-reporting components.

## Data Collection

BroadBoard does not collect any of the following:

- Typed content, keystrokes, or clipboard data
- Personal information (name, email, contacts, location, etc.)
- Device identifiers
- Usage statistics or analytics
- Crash reports

No data of any kind is transmitted off the device, because the app does not request the `INTERNET` permission and contains no networking code.

## Permissions

| Permission        | Purpose                                  |
| ----------------- | ---------------------------------------- |
| BIND_INPUT_METHOD | Required by Android for all IME services |

None of the permissions requested by this app enable data collection or network communication.

## Third Parties

BroadBoard contains no third-party SDKs for advertising, analytics, or telemetry. No data is shared with any third party, because none is collected.

## Local Storage

BroadBoard stores user preferences — such as size preference, color theme, and layout settings — locally on the device using [AndroidX DataStore](https://developer.android.com/topic/libraries/architecture/datastore). This data:

- Never leaves the device
- Is not transmitted to any server, developer, or third party
- Is only readable by BroadBoard itself, per Android's standard app sandboxing

BroadBoard does not build or store a personal dictionary, word-prediction history, or any record of typed content. Nothing about what you type is retained once you've typed it.

Uninstalling the app removes all locally stored preference data.

## Children's Privacy

BroadBoard does not knowingly collect data from anyone, including children, because it does not collect data from any user.

## Changes to This Policy

Any future change to this policy — including any change to what data is collected — will be reflected here with an updated date, and significant changes will be noted in the app's release notes.

## Source Code

BroadBoard is open source under the GNU General Public License v3.0. Every claim in this policy can be independently verified by inspecting the source code and manifest at:

[https://github.com/galagidae/broadboard](https://github.com/galagidae/broadboard)
