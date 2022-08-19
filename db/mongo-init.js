db = db.getSiblingDB("mongo_instaclass");
db.createUser({
    "roles":[{
        "db": "mongo_instaclass"
    }]
})
db.createCollection("instaclass_collection")