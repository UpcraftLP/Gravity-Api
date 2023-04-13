# Gravity API
A fabric mod and api that lets you change player gravity direction.

## Features
This mod adds 6 items that let you change your gravity to any of the 6 axis directions.  
These items are currently uncraftable and can be found in the tools tab of the creative menu.  
This mod can also be used as an API to let other mods change player gravity.

## Required Dependencies
[Cardinal Components API](https://github.com/OnyxStudios/Cardinal-Components-API) (`base`, `entity` and `world`)
[Mixin Extras](https://github.com/LlamaLad7/MixinExtras)
[Quilted Fabric API](https://github.com/QuiltMC/quilted-fabric-api)


## Optional Dependencies
[Mod Menu](https://github.com/TerraformersMC/ModMenu)

## Config
This mod has a config located in `.minecraft/config/gravity_api.json`. You can edit it manually or in game using Mod Menu.  
The config has 2 categories: `Client` and `Server`.  
`Client` category contains options that only take effect on the client and need to be set on the client.  
`Server` category contains options that only take effect on the server and need to be set in the server config. If you are playing in single player, your server uses the same config as your client and you can change it from Mod Menu. If you are playing on a server the server config is not updated when you change it on your client, it can only be edited using the server config file.

## Commands
`/gravity get <player>` - gets player's gravity, returns direction index(0-5)  
`/gravity set <direction> <players>` - sets gravity for selected players  
`/gravity rotate <direction> <players>` - rotates gravity for selected players relative to their look direction  
`/gravity randomise <players>` - randomises gravity for selected players

## Importing
To import the mod you can use the Modrinth maven.  
Add the following to your project:

#### grable.properties
```properties
gravity_api_version = 1.0.0
```
Replace `1.0.0` with the version you want to use from [here](https://modrinth.com/mod/gravity-api/versions).

#### build.gradle
```gradle
repositories {
    maven {
		name = "Modrinth"
		url = "https://api.modrinth.com/maven"
		content {
			includeGroup "maven.modrinth"
		}
	}
}

dependencies {
    modImplementation "maven.modrinth:gravity-api:${project.gravity_api_version}"
}
```

#### fabric.mod.json
```json
"depends": {
    "gravity_api": "^1.0.0"
}
```
Replace `1.0.0` with the lowest version of the mod your mod works with

Now you should be able to use methods in `com.fusionflux.gravity_api.api.GravityChangerAPI` class to manipulate player gravity.
