import React from 'react'
import { useParams } from 'react-router';
import { usePostQuery } from '../generated/graphql'
import CreateComment from './CreateComment';

const PostDetail = () => {
  const { id } = useParams();
  const [result] = usePostQuery({ variables: { id: id! } });
  const { data, fetching, error } = result

  if (fetching) return <div>Fetching</div>
  if (error) return <div>Error</div>

  const post = data!.post

  return (
  <div>
    <h1>{post.title}</h1>
    <div>
      {post.author} ({post.category})
    </div>
    <div>
      {post.content}
    </div>
    <div>
      comments:
    </div>
    {post.comments.map((c) => (
      <div>
        <h4>{c.name}</h4>
        <div>{c.content}</div>
        <div>{c.createdAt}</div>
      </div>
    ))}
    <div>
      <CreateComment postId={post.id}/>
    </div>
  </div>
  )
}

export default PostDetail
