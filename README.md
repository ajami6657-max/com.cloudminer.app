# CLOUD MINER

Android application shell for transparently monitoring a legitimate cloud-mining provider.

## Current status
- Android app name: CLOUD MINER
- Application ID: com.cloudminer.app
- Debug APK is built by GitHub Actions.
- No fake hashrate, mining activity, balance, or earnings are displayed.
- Provider connection is intentionally inactive until a specific provider and its official API contract are selected and implemented.

## Build
Run `gradle assembleDebug` with JDK 17 and Android SDK 35, or run the **Android APK** GitHub Actions workflow.

## Important
This app does not mine Bitcoin by itself. Cloud mining requires a real provider, a valid contract, and independently verifiable account data. Never enter an API key until the provider and API endpoint have been verified.
