package com.marionette.training.chapter10

object MonadOptionExample {

  //get the grandchild. elegant no?
  val result = UserService.loadUser("mike")
    .flatMap(_.child)
    .flatMap(_.child)

  val result1 = for {
    user <- UserService.loadUser("mike")
    usersChild <- user.child
    usersGrandChild <- usersChild.child
  } yield usersGrandChild
}

trait User {
  val child: Option[User]
}

object UserService {
  def loadUser(name: String): Option[User] = {
    //Load from database
    None
  }
}

object User {
  def getChild(user: User) = user.child
}